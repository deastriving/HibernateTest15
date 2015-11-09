import hibernate.db.HibernateUtil;
import hibernate.db.User;

import org.hibernate.Session;

public class Example {

    public static void main(String[] args) {
        User user = getUser(1);
        System.out.println(user.getLogin());
        User oleg = getUser(2);
        System.out.println(oleg.getLogin());
        HibernateUtil.getSessionFactory().close();

       //rv HibernateUtil.getSessionFactory().close();
    }

    public static User getUser(Integer userId) {
        Session session = HibernateUtil.getSessionFactory()
                .getCurrentSession();
        session.beginTransaction();
        User user = (User) session.get(User.class, userId);
        session.getTransaction().commit();
        return user;// ����az
    }

}