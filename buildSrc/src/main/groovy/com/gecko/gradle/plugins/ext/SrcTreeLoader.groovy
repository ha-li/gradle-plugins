package com.gecko.gradle.plugins.ext

import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction

/**
 * Created by hlieu on 01/20/17.
 */
class SrcTreeLoader extends DefaultTask {
   String srcDir

   @TaskAction
   public void loadSrcTree() {
      project.fileTree(srcDir).each {
         File f ->
            println f.canonicalPath
      }
   }
}
