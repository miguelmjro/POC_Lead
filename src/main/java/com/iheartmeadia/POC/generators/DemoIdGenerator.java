package com.iheartmeadia.POC.generators;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.id.IdentifierGenerator;

public class DemoIdGenerator implements IdentifierGenerator{

    @Override
    public Serializable generate(SessionImplementor session, Object object)
            throws HibernateException {

        String prefix = "DEMO";
        Connection connection = session.connection();

        System.out.println("Generated Id start: " );

        try {
            Statement statement=connection.createStatement();

            ResultSet rs=statement.executeQuery("select count(dse__demo_id__c) as Id from salesforce.lead");

            if(rs.next())
            {
                int id=rs.getInt(1)+101;
                String generatedId = prefix + new Integer(id).toString();
                System.out.println("Generated Id: " + generatedId);
                return generatedId;
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


        return null;
    }
}
