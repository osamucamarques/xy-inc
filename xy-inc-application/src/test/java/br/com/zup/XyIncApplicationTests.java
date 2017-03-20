package br.com.zup;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.glassfish.jersey.client.HttpUrlConnectorProvider.ConnectionFactory;
import org.junit.ClassRule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.github.geowarin.junit.DockerRule;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import br.com.zup.rest.api.InterestPointResource;
import br.com.zup.vo.InterestPointVO;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = XyIncApplication.class)
public class XyIncApplicationTests {

	@Autowired
	private InterestPointResource controller;

	@LocalServerPort
	private int port;

	@Autowired
	private MockMvc mockMvc;

	@ClassRule
	public static DockerRule rabbitRule = DockerRule.builder()
			.cmd("docker run -d --net=xy-inc-network --name=xy-inc-mysql -e MYSQL_ROOT_PASSWORD=xy-inc -e MYSQL_DATABASE=xy-inc -e MYSQL_USER=xy-inc -e MYSQL_PASSWORD=xy-inc mysql:5.6")
			.waitForLog("Server startup complete").build();

	@Test
	public void testConnectsToDocker() throws Exception {
		com.rabbitmq.client.ConnectionFactory factory = new com.rabbitmq.client.ConnectionFactory();
		factory.newConnection(rabbitRule.getDockerHost(), rabbitRule.getHostPort("5672/tcp"));
	}

	@Test
	public void contextLoads() {
		assertThat(controller).isNotNull();
	}

	@Test
	public void shouldReturnStatusOk() throws Exception {
		this.mockMvc.perform(get("/xy-inc/api/interestpoint/list")).andDo(print()).andExpect(status().isOk());
	}

	@Test
	public void shouldReturnConstraintExeption() throws Exception {
		InterestPointVO point = new InterestPointVO("Posto", -31, 18);

		Gson gson = new GsonBuilder().serializeNulls().create();
		String json = gson.toJson(point);

		this.mockMvc
				.perform(post("/xy-inc/api/interestpoint/create").contentType(MediaType.APPLICATION_JSON).content(json))
				.andDo(print()).andExpect(status().isInternalServerError());
	}

	@Test
	public void shouldReturnSuccess() throws Exception {
		InterestPointVO point = new InterestPointVO("Posto", 31, 18);

		Gson gson = new GsonBuilder().serializeNulls().create();
		String json = gson.toJson(point);

		this.mockMvc
				.perform(post("/xy-inc/api/interestpoint/create").contentType(MediaType.APPLICATION_JSON).content(json))
				.andDo(print()).andExpect(status().isOk());
	}

	@Test
	public void shouldReturnOkForNearBy() throws Exception {
		this.mockMvc.perform(post("/xy-inc/api/interestpoint/nearby/27/12/10")).andDo(print())
				.andExpect(status().isOk());
	}
}
