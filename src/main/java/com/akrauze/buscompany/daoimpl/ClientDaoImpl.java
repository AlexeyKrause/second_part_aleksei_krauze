package com.akrauze.buscompany.daoimpl;

import com.akrauze.buscompany.dao.ClientDao;
import com.akrauze.buscompany.model.Client;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Slf4j
@Repository
public class ClientDaoImpl extends DaoImplBase implements ClientDao {
    @Autowired
    SqlSession sqlSession;

    public ClientDaoImpl(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    @Override
    public Client getById(int id) {
        log.info("Dao getClientById - " + id);
        Client client = getClientMapper(sqlSession).getById(id);
        log.info("Dao getClientById - " + client);
        return client;
    }

    @Override
    public Client getByLogin(String login) {
        log.info("Dao getClientByLogin - " + login);
        return getClientMapper(sqlSession).getByLogin(login);
    }

    @Override
    public Client insert(Client client, int userId) {
        log.info("DAO insert Client {}", client);
        getClientMapper(sqlSession).insert(client, userId);
        return client;
    }

    @Override
    public Client update(Client client) {
        return null;
    }

    @Override
    public void delete(int id) {

    }
}
