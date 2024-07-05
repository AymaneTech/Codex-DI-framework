package ma.codex.DIFramework.Utils.Scanners;

import org.burningwave.core.assembler.ComponentContainer;
import org.burningwave.core.classes.ClassCriteria;
import org.burningwave.core.classes.ClassHunter;
import org.burningwave.core.classes.SearchConfig;

import java.lang.annotation.Annotation;
import java.util.Collection;

public class ScanByAnnotation {
    private Class<? extends Annotation> annotation;

    public ScanByAnnotation(Class<? extends Annotation> annotation) {
        this.annotation = annotation;
    }

    public Collection<Class<?>> find(String packageName) {
        ClassHunter classHunter = ComponentContainer.getInstance().getClassHunter();

        try (ClassHunter.SearchResult result = classHunter.findBy(
                SearchConfig.forResources(packageName)
                        .by(ClassCriteria.create()
                                .allThoseThatMatch((cls) -> !cls.isAnnotation() && cls.isAnnotationPresent(annotation)))
        )
        ) {
            return result.getClasses();
        }
    }

}
