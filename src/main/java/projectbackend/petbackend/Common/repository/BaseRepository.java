package projectbackend.petbackend.Common.repository;

import org.apache.commons.lang3.reflect.FieldUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import projectbackend.petbackend.Common.utils.FileUtil;
import projectbackend.petbackend.Data.Dto.Datatable;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.io.*;
import java.lang.reflect.Field;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class BaseRepository<T> {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public NamedParameterJdbcTemplate getNamedParameterJdbcTemplate() {
        return namedParameterJdbcTemplate;
    }

    public Datatable getListDataTableBySqlQuery(String sqlQuery, Map<String, Object> parameters,
                                                int page, int pageSize, Class<?> mappedClass, String sortName, String sortType) {
        Datatable dataReturn = new Datatable();
        String sqlQueryResult = " SELECT * FROM ( SELECT * FROM ( SELECT * FROM ( "
                + sqlQuery
                + " ) abc ";
//        if (sortName != null) {
//            Field[] fields = FieldUtils.getAllFields(mappedClass);
//            Map<String, String> mapField = new HashMap<>();
//            for (Field field : fields) {
//                mapField.put(field.getName(), field.getName());
//            }
//            if ("asc".equalsIgnoreCase(sortType)) {
//                sqlQueryResult += " ORDER BY " + mapField.get(sortName) + " ASC";
//            } else if ("desc".equalsIgnoreCase(sortType)) {
//                sqlQueryResult += " ORDER BY " + mapField.get(sortName) + " DESC";
//            } else {
//                sqlQueryResult += " ORDER BY " + mapField.get(sortName);
//            }
//        }
        sqlQueryResult += " ) bcd LIMIT :p_page_length offset :p_page_number ) T_TABLE_NAME, ";
        sqlQueryResult += " ( SELECT COUNT(*) totalRow FROM ( "
                + sqlQuery
                + " ) T_TABLE_TOTAL ) ";
        sqlQueryResult += "T_TABLE_NAME_TOTAL ";
        parameters.put("p_page_number", (page - 1) * pageSize);
        parameters.put("p_page_length", pageSize);
        List<?> list = getNamedParameterJdbcTemplate().query(sqlQueryResult, parameters, BeanPropertyRowMapper.newInstance(mappedClass));
        int count = 0;
        if (list.isEmpty()) {
            dataReturn.setTotal(count);
        } else {
            try {
                Object obj = list.get(0);
                Field field = obj.getClass().getSuperclass().getDeclaredField("totalRow");
                field.setAccessible(true);
                count = Integer.parseInt(field.get(obj).toString());
                dataReturn.setTotal(count);
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        if (pageSize > 0) {
            if (count % pageSize == 0) {
                dataReturn.setPages(count / pageSize);
            } else {
                dataReturn.setPages((count / pageSize) + 1);
            }
        }
        dataReturn.setData(list);
        return dataReturn;
    }

    @SuppressWarnings("unchecked")
    public List<T> findAll(Class<T> persistentClass) {
        String sqlQuery = " SELECT t FROM " + persistentClass.getSimpleName() + " t";
        return entityManager.createQuery(sqlQuery).getResultList();
    }

    @SuppressWarnings("unchecked")
    public List<T> findByMultilParam(Class<T> persistentClass, Object... params) {
        Map<String, Object> mapParams = new HashMap<>();
        String sqlQuery = " SELECT t FROM " + persistentClass.getSimpleName() + " t WHERE 1=1 ";
        if (params.length > 0) {
            for (int i = 0; i < params.length; i++) {
                if (i % 2 == 0) {
                    sqlQuery += " AND t." + params[i] + " = :p_" + params[i] + " ";
                    mapParams.put("p_" + params[i], params[i + 1]);
                }
            }
        }
        Query query = entityManager.createQuery(sqlQuery);
        for (Map.Entry<String, Object> entry : mapParams.entrySet()) {
            query.setParameter(entry.getKey(), entry.getValue());
        }
        return query.getResultList();
    }

    public String getSQLQueryFromFile(String resourceFolder, String fileName) {
        StringBuilder stringBuilder = null;
        BufferedReader bufferedReader = null;
        InputStreamReader inputStreamReader = null;
        try {
            String filePath = "sql/" + resourceFolder + "/" + fileName + ".sql";
            InputStream inputStream = FileUtil.class.getClassLoader().getResourceAsStream(filePath);
            inputStreamReader = new InputStreamReader(inputStream);
            bufferedReader = new BufferedReader(inputStreamReader);
            String str;
            stringBuilder = new StringBuilder();
            while ((str = bufferedReader.readLine()) != null) {
                stringBuilder.append(str + " ");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bufferedReader != null)
                    bufferedReader.close();
                if (inputStreamReader != null)
                    inputStreamReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return stringBuilder.toString();
    }

    public String getSQLFromFile(String resourceFolder, String fileName) {
        File folder;
        try {
            folder = new ClassPathResource("sql" + File.separator + resourceFolder + File.separator + fileName + ".sql").getFile();

            if (folder.isFile()) {
                String sql = new String(Files.readAllBytes(Paths.get(folder.getAbsolutePath())));
                return sql;
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return null;
    }

}
