package online.shop.services.impl;

import online.shop.dao.ConnectionWrapper;
import online.shop.dao.DaoFactory;
import online.shop.dao.UserDao;
import online.shop.model.entity.User;
import online.shop.services.UserService;

import java.util.List;
import java.util.Optional;

/**
 * Created by andri on 1/21/2017.
 */
public class UserServiceImpl implements UserService {
    private DaoFactory daoFactory = DaoFactory.getInstance();

    private UserServiceImpl(){}

    private static UserService instance;

    public static synchronized  UserService getInstance(){
        if(instance==null){
            instance = new UserServiceImpl();
        }
        return instance;
    }

    @Override
    public Optional<User> findById(int id) {
        try(ConnectionWrapper wrapper = daoFactory.getConnection()){
            UserDao userDao = daoFactory.getUserDao(wrapper);
            return userDao.findById(id);
        }
    }

    @Override
    public Optional<User> findUserByEmail(String email) {
        try(ConnectionWrapper wrapper = daoFactory.getConnection()){
            UserDao userDao = daoFactory.getUserDao(wrapper);
            return userDao.findUserByEmail(email);
        }
    }

    @Override
    public Optional<User> login(String email, String password) {
        try(ConnectionWrapper wrapper = daoFactory.getConnection() ){
            UserDao userDao = daoFactory.getUserDao(wrapper);
            return userDao.findUserByEmail(email)
                    .filter( person-> password.equals(person.getPassword()));
        }
    }

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public void create(User user) {
        try(ConnectionWrapper wrapper = daoFactory.getConnection() ){
            UserDao userDao = daoFactory.getUserDao(wrapper);
            userDao.create(user);
        }
    }

    @Override
    public void update(User user) {

    }

    @Override
    public void delete(int id) {

    }
}
