import org.jbehave.core.Embeddable;
import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.configuration.MostUsefulConfiguration;
import org.jbehave.core.embedder.StoryControls;
import org.jbehave.core.io.CodeLocations;
import org.jbehave.core.io.LoadFromClasspath;
import org.jbehave.core.io.StoryFinder;
import org.jbehave.core.io.UnderscoredCamelCaseResolver;
import org.jbehave.core.junit.JUnitStories;
import org.jbehave.core.reporters.CrossReference;
import org.jbehave.core.reporters.FilePrintStreamFactory;
import org.jbehave.core.reporters.Format;
import org.jbehave.core.reporters.StoryReporterBuilder;
import org.jbehave.core.steps.InjectableStepsFactory;
import org.jbehave.core.steps.InstanceStepsFactory;
import org.junit.Test;

import java.util.List;
import java.util.Properties;

/**
 * Created with IntelliJ IDEA.
 * User: ms
 * Date: 5/3/13
 * Time: 8:25 AM
 * To change this template use File | Settings | File Templates.
 */
public class JBehaveScenarios
        extends JUnitStories {

    private final CrossReference xref = new CrossReference();



    public JBehaveScenarios() {
        configuredEmbedder().embedderControls().doGenerateViewAfterStories( true ).doIgnoreFailureInStories( true )
                            .doIgnoreFailureInView( true ).useThreads( 2 ).useStoryTimeoutInSecs( 60 );
        // Uncomment to set meta filter, which can also be set via Ant or Maven
        // configuredEmbedder().useMetaFilters(Arrays.asList("+theme parametrisation"));
    }



    @Override
    public Configuration configuration() {
        Class<? extends Embeddable> embeddableClass = this.getClass();
        Properties viewResources = new Properties();
        viewResources.put( "decorateNonHtml", "true" );

        return new MostUsefulConfiguration()
                .useStoryControls( new StoryControls().doDryRun( false ).doSkipScenariosAfterFailure( false ) )
                .useStoryLoader( new LoadFromClasspath( embeddableClass ) )
                .useStoryPathResolver( new UnderscoredCamelCaseResolver() )
                .useStoryReporterBuilder(
                        new StoryReporterBuilder()
                                .withCodeLocation( CodeLocations.codeLocationFromClass( embeddableClass ) )
                                .withDefaultFormats()
                                .withPathResolver( new FilePrintStreamFactory.ResolveToPackagedName() )
                                .withViewResources( viewResources )
                                .withFormats( Format.CONSOLE, Format.TXT, Format.HTML, Format.XML )
                                .withFailureTrace( true ).withFailureTraceCompression( true )
                                .withCrossReference( xref ) );
    }



    @Override
    public InjectableStepsFactory stepsFactory() {
        return new InstanceStepsFactory( configuration(), new StackSteps() );
    }



    @Override
    @Test
    public void run() {
        try {
            super.run();
        } catch ( Throwable e ) {
            e.printStackTrace();
        }
    }



    @Override
    protected List<String> storyPaths() {
        return new StoryFinder().findPaths( CodeLocations.codeLocationFromClass( this.getClass() ), "**/*.story",
                                            "**/excluded*.story" );
    }
}
