package de.hegmanns.spring.schulung.demo;

import java.util.List;

public interface ContactDao {
    List<Contact> getAll();
    List<Contact> getAllWithDetail();
    Contact getById(Long id);
    Contact add(Contact contact);
    void delete(Contact contact);
}
