package com.vocabularysrs;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.vocabularysrs.domain.AdjustableClock;
import com.vocabularysrs.infrastructure.security.jwt.vocabulary.JwtTokenGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.utility.DockerImageName;

import java.time.Clock;

@SpringBootTest(classes = {VocabularySrsApplication.class, IntegrationConfiguration.class})
@ActiveProfiles("integration")
@AutoConfigureMockMvc
@Testcontainers
public class BaseIntegrationTest {

    @Container
    public static final PostgreSQLContainer<?> postgreSQLContainer = new PostgreSQLContainer<>(DockerImageName.parse("postgres:15"));

    @Autowired
    public MockMvc mockMvc;

    @MockitoBean
    public JwtTokenGenerator jwtTokenGenerator;

    @Autowired
    public ObjectMapper objectMapper;
    @Autowired
    Clock clock;

    @DynamicPropertySource
    public static void propertyOverride(DynamicPropertyRegistry registry) {
        registry.add("spring.datasource.url", postgreSQLContainer::getJdbcUrl);
        registry.add("spring.datasource.username", postgreSQLContainer::getUsername);
        registry.add("spring.datasource.password", postgreSQLContainer::getPassword);

    }

    protected AdjustableClock adjustableClock() {
        return (AdjustableClock) clock;
    }

    protected String authenticatedUser() {
        return "Bearer test-token";
    }
}


