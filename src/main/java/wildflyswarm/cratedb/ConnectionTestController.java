package wildflyswarm.cratedb;

import javax.annotation.Resource;
import javax.enterprise.context.ApplicationScoped;
import javax.sql.DataSource;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;

@ApplicationScoped
@Path("/")
public class ConnectionTestController {

  @Resource
  private DataSource ds;

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public DatabaseMetaDataResponse get() {
    try (Connection conn = ds.getConnection()) {

      DatabaseMetaData metaData = conn.getMetaData();
      return new DatabaseMetaDataResponse(
        metaData.getDatabaseProductName(),
        metaData.getDatabaseMajorVersion(),
        metaData.getDriverVersion()
      );
    } catch (SQLException e) {
      e.printStackTrace();
    }

    return new DatabaseMetaDataResponse("Unknown", -1, "Unknown");
  }

}