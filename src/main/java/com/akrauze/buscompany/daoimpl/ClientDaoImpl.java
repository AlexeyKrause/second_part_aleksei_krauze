package com.akrauze.buscompany.daoimpl;

import com.akrauze.buscompany.dao.ClientDao;
import com.akrauze.buscompany.model.Client;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

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
        log.info("ClientDao getClientById {} - ", id);
        Client client = getClientMapper(sqlSession).getById(id);
        log.info("ClientDao getClientById - " + client);
        return client;
    }

    @Override
    public Client getByLogin(String login) {
        log.info("ClientDao getClientByLogin {} - ", login);
        return getClientMapper(sqlSession).getByLogin(login);
    }

    @Override
    public Client getByJavaSessionId(String javaSessionId) {
        log.info("ClientDao getClientByJavaSessionId {} - ", javaSessionId);
        return getClientMapper(sqlSession).getByJavaSessionId(javaSessionId);
    }

    @Override
    public List<Client> getAll() {
        log.info("ClientDao getAllClients");
        return getClientMapper(sqlSession).getAll();
    }

    @Override
    public Client insert(Client client, int userId) {
        log.info("ClientDao insert Client {}", client);
        getClientMapper(sqlSession).insert(client, userId);
        return client;
    }

    @Override
    public void update(Client client, int userId) {
        log.info("ClientDao update Client {}", client);
        getClientMapper(sqlSession).update(client, userId);
    }

    @Override
    public void delete(int id) {

    }
}
