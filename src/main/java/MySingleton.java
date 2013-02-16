import pl.itcrowd.tutorials.tutorialEntity.domain.Post;
import pl.itcrowd.tutorials.tutorialEntity.domain.User;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.logging.Logger;

/**
 * Created with IntelliJ IDEA.
 * User: klex
 * Date: 2/1/13
 * Time: 2:14 PM
 * To change this template use File | Settings | File Templates.
 */
@Startup
@Singleton
public class MySingleton {

    private static final Logger LOGGER = Logger.getLogger(MySingleton.class.getCanonicalName());

    @PersistenceContext
    EntityManager entityManager;

    public MySingleton() {

    }
    public void getIssetPostByFind(){
        //        get post for id = 3 using entity manager.find
        Post post = entityManager.find(Post.class, 3);
        LOGGER.info("getPostById= " + post);
    }


    @PostConstruct
    public void PostConstruct() {
        //persist
        generateUsers();
        generatePosts();
        getIssetPostByFind();
    }


    public void generatePosts() {



        final List<User> users = entityManager.createQuery("select u from User u order by u.id")
                .getResultList();


        final Post post1 = new Post("post1", "content1", users.get(0));
        final Post post2 = new Post("post2", "content2", users.get(1));
        final Post post3 = new Post("post3", "content3", users.get(2));
        final Post post4 = new Post("post4", "content4", users.get(0));
        final Post post5 = new Post("post5", "content5", users.get(3));
        final Post post6 = new Post("post6", "content6", users.get(0));
        final Post post7 = new Post("post7", "content7", users.get(0));
        final Post post8 = new Post("post8", "content8", users.get(1));
        final Post post9 = new Post("post9", "content9", users.get(0));
        final Post post10 = new Post("post10", "content10", users.get(2));
        final Post post11 = new Post("post11", "content11", users.get(0));
        final Post post12 = new Post("post12", "content12", users.get(0));
        final Post post13 = new Post("post13", "content13", users.get(3));
        final Post post14 = new Post("post14", "content14", users.get(0));
        final Post post15 = new Post("post15", "content15", users.get(0));

        entityManager.persist(post1);
        entityManager.persist(post2);
        entityManager.persist(post3);
        entityManager.persist(post4);
        entityManager.persist(post5);
        entityManager.persist(post6);
        entityManager.persist(post7);
        entityManager.persist(post8);
        entityManager.persist(post9);
        entityManager.persist(post10);
        entityManager.persist(post11);
        entityManager.persist(post12);
        entityManager.persist(post13);
        entityManager.persist(post14);
        entityManager.persist(post15);
    }


    public void generateUsers() {

        final User user1 = new User("John");
        final User user2 = new User("Frank");
        final User user3 = new User("James");
        final User user4 = new User("George");

        entityManager.persist(user1);
        entityManager.persist(user2);
        entityManager.persist(user3);
        entityManager.persist(user4);
    }
}