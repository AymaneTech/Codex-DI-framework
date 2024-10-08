package ma.codex.framework.utils;

import org.burningwave.core.assembler.ComponentContainer;
import org.burningwave.core.classes.ClassCriteria;
import org.burningwave.core.classes.ClassHunter;
import org.burningwave.core.classes.SearchConfig;

import java.lang.annotation.Annotation;
import java.util.Collection;

public class ScanByAnnotation {
    private Class<? extends Annotation> annotation;

    public ScanByAnnotation() {
    }

    public ScanByAnnotation(Class<? extends Annotation> annotation) {
        this.annotation = annotation;
    }

    public void setAnnotation(Class<? extends Annotation> annotation) {
        this.annotation = annotation;
    }

    public Collection<Class<?>> find(final String packageName) {
        final ClassHunter classHunter = ComponentContainer.getInstance().getClassHunter();

        try (final ClassHunter.SearchResult result = classHunter.findBy(
                SearchConfig.forResources(packageName)
                        .by(ClassCriteria.create()
                                .allThoseThatMatch((cls) -> !cls.isAnnotation() && cls.isAnnotationPresent(annotation)))
        )
        ) {
            return result.getClasses();
        } catch (RuntimeException e) {
            throw new RuntimeException("Error while scanning for annotation " + annotation, e);
        }
    }

}
