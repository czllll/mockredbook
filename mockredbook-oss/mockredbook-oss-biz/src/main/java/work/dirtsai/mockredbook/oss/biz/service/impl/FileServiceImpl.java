package work.dirtsai.mockredbook.oss.biz.service.impl;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import work.dirtsai.framework.biz.context.holder.LoginUserContextHolder;
import work.dirtsai.framework.common.response.Response;
import work.dirtsai.mockredbook.oss.biz.service.FileService;
import work.dirtsai.mockredbook.oss.biz.strategy.FileStrategy;

@Service
@Slf4j
public class FileServiceImpl implements FileService {

    @Resource
    private FileStrategy fileStrategy;

    private static final String BUCKET_NAME = "mockbook";

    @Override
    public Response<?> uploadFile(MultipartFile file) {
        // 上传文件
        String url = fileStrategy.uploadFile(file, BUCKET_NAME);
        log.info("当前用户 ID: {}", LoginUserContextHolder.getUserId());

        return Response.success(url);
    }
}
