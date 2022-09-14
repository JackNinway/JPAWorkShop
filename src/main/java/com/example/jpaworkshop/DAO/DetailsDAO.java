package com.example.jpaworkshop.DAO;

import com.example.jpaworkshop.Entity.Appuser;
import com.example.jpaworkshop.Entity.Details;

import java.util.Collection;

public interface DetailsDAO {
    Details findById(int id);
    Collection<Details> findAll();
    Details create(Details details);
    Details update(Details details);
    void delete(int id);

}
