package com.gecko.gradle.plugins.ext

import org.gradle.api.DefaultTask
import org.gradle.api.GradleException
import org.gradle.api.tasks.Input
import org.gradle.api.tasks.TaskAction

/**
 * Created by hlieu on 01/17/17.
 */
abstract class ResourceLoader extends DefaultTask {
   String resource
   File file

   ResourceLoader (String description) {
      this.description = description
      group = 'info'
   }

   abstract void executeAction ()

   @TaskAction
   void start () {
      withExceptionHandling {
         executeAction ()
      }
   }

   private void withExceptionHandling (Closure c) {
      try {
         c ()
      } catch (Exception e) {
         throw new GradleException (e.message);
      }
   }
}
