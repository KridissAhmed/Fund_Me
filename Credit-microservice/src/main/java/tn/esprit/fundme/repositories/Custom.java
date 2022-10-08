package tn.esprit.fundme.repositories;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class Custom implements ICustom {

  @Autowired
  private EntityManager entityManager;

  @Override
  public Object accepted() {
     return entityManager.createNativeQuery("SELECT  mon.m as months, mon.n as i  , IFNULL(w.TOTAL,0) as tot FROM month mon \r\n"
     		+ "LEFT OUTER JOIN \r\n"
     		+ "(SELECT MONTH(c.start_date) z, count(*) AS TOTAL \r\n"
     		+ "     		 FROM credits c\r\n"
     		+ "     		Where c.start_date >= DATE_SUB(now(), INTERVAL 6 MONTH) AND c.state=\"ACCEPTED\"\r\n"
     		+ "            GROUP BY MONTH(c.start_date)\r\n"
     		+ "             \r\n"
     		+ "         ) as w\r\n"
     		+ "        on mon.n =w.z\r\n"
     		+ "        Order by i\r\n"
     		+ "        \r\n"
     		+ "        ")
       .getResultList();
  }
  @Override
  public Object total() {
     return entityManager.createNativeQuery("SELECT  mon.m as months, mon.n as i  , IFNULL(w.TOTAL,0) as tot FROM month mon \r\n"
      		+ "LEFT OUTER JOIN \r\n"
      		+ "(SELECT MONTH(c.start_date) z, count(*) AS TOTAL \r\n"
      		+ "     		 FROM credits c\r\n"
      		+ "     		Where c.start_date >= DATE_SUB(now(), INTERVAL 6 MONTH) GROUP BY MONTH(c.start_date)\r\n"
      		+ "             \r\n"
      		+ "         ) as w\r\n"
      		+ "        on mon.n =w.z\r\n"
      		+ "        Order by i\r\n"
      		+ "        \r\n"
      		+ "        ")
       .getResultList();
  }
}
