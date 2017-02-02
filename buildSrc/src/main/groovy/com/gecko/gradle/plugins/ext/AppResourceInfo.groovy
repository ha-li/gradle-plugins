package com.gecko.gradle.plugins.ext

/**
 * Created by hlieu on 02/1/17.
 */
class AppResourceInfo extends ResourceLoader {

   AppResourceInfo () {
      super ('Loads a resource to stdout')
   }

   @Override
   void executeAction () {
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
