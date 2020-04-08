package com.KSHRD.springsecurity4.configuration;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.context.SecurityContext;

import springfox.documentation.RequestHandler;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ResponseMessage;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.service.SecurityScheme;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.ApiKeyVehicle;
import springfox.documentation.swagger.web.SecurityConfiguration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import springfox.documentation.service.OAuth;
import springfox.documentation.service.ResourceOwnerPasswordCredentialsGrant;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.GrantType;

@Configuration
@EnableSwagger2
public class SpringFoxConfig {
    final String authLink="http://localhost:22000/";
    final String authTokenLink=authLink+"oauth/token";
    @Bean
    public Docket api(){

            final List<ResponseMessage> list=new ArrayList<>();
            list.add(new ResponseMessageBuilder().code(500).message("500 message").responseModel(new ModelRef("Resutl")).build());
            list.add(new ResponseMessageBuilder().code(401).message("Unauthorized")
            .responseModel(new ModelRef("Result")).build());
            list.add(new ResponseMessageBuilder().code(406).message("Not Acceptable")
            .responseModel(new ModelRef("Result")).build());
    
            return new Docket(DocumentationType.SWAGGER_2)
                    .select()
                    .apis(RequestHandlerSelectors.basePackage("com.KSHRD.springsecurity4.Controller"))
                    .paths(PathSelectors.regex("/api.*"))
                    .build()
                    .apiInfo(apiInfo())
                    .securitySchemes(Collections.singletonList(securitySchema()))
                    // .securityContexts(Collections.singletonList(securityContext())).pathMapping("/")
                .useDefaultResponseMessages(true);
                

    }
    private ApiInfo apiInfo(){
        return new ApiInfoBuilder()
                .title("hello my api ")
                .description("Developing")
                .version("1.0")
                .build();
    }

    private OAuth securitySchema(){
       
        final List<AuthorizationScope> authorizationScopeList = new ArrayList<>();
        authorizationScopeList.add(new AuthorizationScope("read", "read all"));
        authorizationScopeList.add(new AuthorizationScope("trust", "trust all"));
        authorizationScopeList.add(new AuthorizationScope("write", "access all"));
        final List<GrantType> grantTypes=new ArrayList();
        final GrantType creGrant=new  ResourceOwnerPasswordCredentialsGrant(authTokenLink);
        grantTypes.add(creGrant);
        return new  OAuth("oauth2shchema",authorizationScopeList,grantTypes);

    }
    // private SecurityContext securityContext() {
    //     return SecurityContext.builder().securityReferences(defaultAuth()).forPaths(PathSelectors.ant("/user/**"))
    //             .build();
    // }

    private List<SecurityReference> defaultAuth() {

        final AuthorizationScope[] authorizationScopes = new AuthorizationScope[3];
        authorizationScopes[0] = new AuthorizationScope("read", "read all");
        authorizationScopes[1] = new AuthorizationScope("trust", "trust all");
        authorizationScopes[2] = new AuthorizationScope("write", "write all");

        return Collections.singletonList(new SecurityReference("oauth2schema", authorizationScopes));
    }

    @Bean
    public SecurityConfiguration securityInfo() {
        return new SecurityConfiguration("auth_user", "auth_user", "", "", "", ApiKeyVehicle.HEADER, "", " ");
    }

}