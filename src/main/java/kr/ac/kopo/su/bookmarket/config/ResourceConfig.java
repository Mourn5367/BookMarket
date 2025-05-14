package kr.ac.kopo.su.bookmarket.config;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class ResourceConfig implements WebMvcConfigurer
{
    @Value("${file.uploadDir}")
    String fileDir;

    @Override
    public void addResourceHandlers (ResourceHandlerRegistry registry)
   {
       // 이미지 파일을 찾으려면 여기로 오시라.
        registry.addResourceHandler("/images/**").
            // 실제로 찾을 이미지 파일 위치는 여깄다 !
                addResourceLocations("file:///"+fileDir).
                setCachePeriod(60 * 60 * 24 * 365);
        // url과 uri
        // 접근 파일 캐싱 시간 s 단위


   }
}
