package tech.alexengrig.jenkins.sharedlibrary

import com.cloudbees.groovy.cps.NonCPS
import hudson.EnvVars
import hudson.slaves.EnvironmentVariablesNodeProperty
import hudson.slaves.NodeProperty
import hudson.slaves.NodePropertyDescriptor
import hudson.util.DescribableList
import jenkins.model.Jenkins

class GlobalEnv {

    @NonCPS
    static void createGlobalEnv(String key, String value) {
        Jenkins instance = Jenkins.getInstance();

        DescribableList<NodeProperty<?>, NodePropertyDescriptor> globalNodeProperties = instance.getGlobalNodeProperties();
        List<EnvironmentVariablesNodeProperty> envVarsNodePropertyList = globalNodeProperties.getAll(EnvironmentVariablesNodeProperty.class);

        EnvironmentVariablesNodeProperty newEnvVarsNodeProperty = null;
        EnvVars envVars = null;

        if (envVarsNodePropertyList == null || envVarsNodePropertyList.size() == 0) {
            newEnvVarsNodeProperty = new EnvironmentVariablesNodeProperty();
            globalNodeProperties.add(newEnvVarsNodeProperty);
            envVars = newEnvVarsNodeProperty.getEnvVars();
        } else {
            envVars = envVarsNodePropertyList.get(0).getEnvVars();
        }
        envVars.put(key, value)
        instance.save()
    }

}
