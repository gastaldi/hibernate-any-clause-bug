package org.acme;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.sql.DataSource;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import java.sql.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@Path("/")
public class MyService {

    @Inject
    EntityManager entityManager;

    @Inject
    DataSource dataSource;

    @GET
    @Path("/datasource")
    public Response fromDataSource() throws Exception {
        String[] elements = { "field-1", "field-2", "field-3" };
        try (Connection con = dataSource.getConnection();
                PreparedStatement ps = con.prepareStatement("select field from MyEntity where field = ANY(?)")) {
            Array array = con.createArrayOf("varchar", elements);
            ps.setArray(1, array);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getString(1));
            }
        }
        return Response.ok().build();
    }

    @GET
    @Path("/hibernate")
    public Response fromHibernate() throws Exception {
        String[] elements = { "field-1", "field-2", "field-3" };
        System.out.println(entityManager.createNativeQuery("select field from MyEntity where field = ANY(?1)")
                .setParameter(1, elements)
                .getResultList());
        return Response.ok().build();
    }

}
