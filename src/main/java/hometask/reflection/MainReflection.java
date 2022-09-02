package hometask.reflection;

import hometask.agency.RealEstateAgency;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.lang.reflect.*;

public class MainReflection {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        final Logger LOG_REFLECT = LogManager.getLogger(MainReflection.class.getName());

        Class myEstateAgencyReflectionClass = RealEstateAgency.class;
        int classModifier = myEstateAgencyReflectionClass.getModifiers();
        LOG_REFLECT.info("Is the class abstract? " + Modifier.isAbstract(classModifier));
        Method[] methods = myEstateAgencyReflectionClass.getMethods();
        for (Method method : methods) {
            LOG_REFLECT.info("Method of class" + myEstateAgencyReflectionClass.getSimpleName() + ": " + method.getName() + " has return type " + method.getReturnType().getSimpleName());
            if (method.getName().startsWith("get")) {
                LOG_REFLECT.info("This method is a getter");
            } else if (method.getName().startsWith("set")) {
                LOG_REFLECT.info("This method is a setter");
            }
        }
        Field[] fields = myEstateAgencyReflectionClass.getDeclaredFields();
        for (Field field : fields) {
            LOG_REFLECT.info("Field of the class " + myEstateAgencyReflectionClass.getSimpleName() + ": " + field.getName() + " is of type " + field.getType().getSimpleName());
        }
        Constructor[] constructors = myEstateAgencyReflectionClass.getConstructors();
        Method reflected = myEstateAgencyReflectionClass.getDeclaredMethod("agencyAddress");
        LOG_REFLECT.info("Call of method " + reflected.getName() + " using reflection and new instance will return: " + reflected.invoke(constructors[0].newInstance()));

    }
}
