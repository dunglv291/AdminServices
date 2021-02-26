package projectbackend.petbackend.Common.service;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;
import java.util.stream.Stream;

public interface FilesStorageService {
    void init();

    void store(MultipartFile file);

    Resource loadAsResource(String filename);

    Path load(String filename);

    Stream<Path> loadAll();

    void deleteAll();


}
