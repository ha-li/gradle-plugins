package com.gecko.gradle.plugins.ext

import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction

/**
 * Created by hlieu on 01/20/17.
 */
class JarTreeLoader extends DefaultTask {

   String jar

   @TaskAction
   public void jarBall () {
      project.tarTree(jar).each {
         File f ->
            println f.canonicalPath
      }
   }
}
