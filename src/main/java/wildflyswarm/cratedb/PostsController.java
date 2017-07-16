package wildflyswarm.cratedb;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ApplicationScoped
@Path("/posts")
public class PostsController {

  private final Gson gson = new GsonBuilder().serializeNulls().create();

  @Inject
  private DataProvider model;

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public List<Map<String, Object>> get() throws SQLException {
    return model.getPosts();
  }

  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  public List<Map<String, Object>> post(String body) throws SQLException {
//    if (body.isEmpty()) {
//      return argumentRequired(response, "Request body is required");
//    }

    //noinspection unchecked
    Map<String, Object> post = gson.fromJson(body, Map.class);
//    if (!post.containsKey("text")) {
//      return argumentRequired(response, "Argument \"text\" is required");
//    }

    //noinspection unchecked
    Map<String, Object> user = (Map) post.get("user");
//    if (!user.containsKey("location")) {
//      return argumentRequired(response, "Argument \"location\" is required");
//    }
//    response.status(CREATED);
    return model.insertPost(post);
  }

}
