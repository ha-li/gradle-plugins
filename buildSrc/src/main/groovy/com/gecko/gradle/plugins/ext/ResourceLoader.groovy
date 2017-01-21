package com.gecko.gradle.plugins.ext

import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction

/**
 * Created by hlieu on 01/17/17.
 */
class ResourceLoader extends DefaultTask {
   String resource
   File file

   @TaskAction
   public void loadThisResource () {
      def files = fileList(resource)
      files.each {
         File file ->
            if (file.isFile()) {
               ant.loadfile (srcFile: file, property: file.name)
               println "****$file.name****"
               println "${ant.properties[file.name]}"
               println "****$file.name****"
            }
      }
   }

   private File[] fileList (String dir) {
      if (this.file == null)
         project.file(dir).listFiles().sort();
      else {
         project.file(file).listFiles().sort();
      }
   }
}
