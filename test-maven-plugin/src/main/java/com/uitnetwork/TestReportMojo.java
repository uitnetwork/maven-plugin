package com.uitnetwork;

import org.apache.maven.doxia.sink.Sink;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;
import org.apache.maven.plugins.annotations.ResolutionScope;
import org.apache.maven.project.MavenProject;
import org.apache.maven.reporting.AbstractMavenReport;
import org.apache.maven.reporting.MavenReportException;

import java.util.Locale;

@Mojo(name = "testReport", defaultPhase = LifecyclePhase.SITE, requiresDependencyResolution = ResolutionScope.RUNTIME)
public class TestReportMojo extends AbstractMavenReport {
    @Parameter(defaultValue = "${project}", readonly = true)
    private MavenProject project;

    @Override
    protected void executeReport(Locale locale) throws MavenReportException {
        getLog().info("Generating report...");

        Sink sink = getSink();

        sink.head();
        sink.title();
        sink.text("Test Report for " + project.getName());
        sink.title_();
        sink.head_();

        sink.body();
        sink.section1();

        sink.paragraph();
        sink.text("This is just an content");
        sink.text("This is just another content");
        sink.paragraph_();

        sink.section1_();
        sink.body_();
    }

    @Override
    public String getOutputName() {
        return "testReport";
    }

    @Override
    public String getName(Locale locale) {
        return "Test Report";
    }

    @Override
    public String getDescription(Locale locale) {
        return "Test Report for Maven Plugin";
    }
}
