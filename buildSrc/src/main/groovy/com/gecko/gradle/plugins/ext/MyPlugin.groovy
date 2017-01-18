package com.gecko.gradle.plugins.ext

import org.gradle.api.Plugin
import org.gradle.api.Project

/**
 * Created by hlieu on 01/17/17.
 */
class MyPlugin implements Plugin<Project> {
   @Override
   public void apply (Project target) {
      target.task ("groovyTask")
   }
}
