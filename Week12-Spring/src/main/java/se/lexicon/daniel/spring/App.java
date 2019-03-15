package se.lexicon.daniel.spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import se.lexicon.daniel.spring.config.ComponentScanConfig;
import se.lexicon.daniel.spring.data.StudentDao;
import se.lexicon.daniel.spring.data.StudentDaoListImpl;
import se.lexicon.daniel.spring.service.UserInputService;

public class App 
{
    public static void main( String[] args )
    {
        AnnotationConfigApplicationContext context =
        		new AnnotationConfigApplicationContext(ComponentScanConfig.class);
        
        StudentDaoListImpl studentDao = context.getBean(StudentDaoListImpl.class);
        UserInputService userInput = context.getBean(UserInputService.class);
        
        userInput.getString("test");
        
        
        context.close();
    }
}
