package com.gecko.gradle.plugins.ext

import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction

/**
 * Created by hlieu on 01/19/17.
 */
class FileCollectionLoader extends DefaultTask {
   Object[] fileList

   @TaskAction
   public void loadAllResources () {
      fileList(fileList)
      booleanList(fileList[0])
   }

   // be careful with return values
   private void fileList (Object[] files) {
      project.files(files).each {
         f2 ->
            println f2.canonicalPath
      }
   }

   private void booleanList (String f) {
      println 'boolean list'
      // you can pass files a closure that evaluates
      // to a value that can be converted to a set files
      // so project.file ('resources') is a directory
      // and that is passed into files ().each
      // to get a filecollection of 1
      project.files { project.file(f) }.each {
         f2 -> println f2.canonicalPath
      }
   }
}
