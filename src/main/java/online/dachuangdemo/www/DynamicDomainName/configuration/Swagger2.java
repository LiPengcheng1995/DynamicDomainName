package online.dachuangdemo.www.DynamicDomainName.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * 代码描述 :
 *
 * @author LiPengcheng
 * date :  2018/1/13 18:25
 * description:
 **/
@Configuration
@EnableSwagger2
public class Swagger2 {
    @Value("${swagger2.description.title}")
    private String title;
    @Value("${swagger2.description.description}")
    private String description;
    @Value("${swagger2.description.serviceUrl}")
    private String serviceUrl;
    @Value("${swagger2.description.contact}")
    private String contact;
    @Value("${swagger2.description.version}")
    private String version;

    @Value("${swagger2.pathRegex}")
    private String swaggerPathRegex;

    @Bean
    public Docket api() {
        return (new Docket(DocumentationType.SWAGGER_2))
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.regex(this.swaggerPathRegex))
                .build()
                .apiInfo(this.apiInfo());
    }

    private ApiInfo apiInfo() {
        return (new ApiInfoBuilder())
                .title(this.title)
                .description(this.description)
                .version(this.version)
                .termsOfServiceUrl(String.format("http://%s", this.serviceUrl))
                .license("LICENSE")
                .licenseUrl(this.serviceUrl)
                .build();
    }

}
