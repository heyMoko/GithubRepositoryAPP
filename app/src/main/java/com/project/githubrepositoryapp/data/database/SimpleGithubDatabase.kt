package com.project.githubrepositoryapp.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.project.githubrepositoryapp.data.dao.RepositoryDao
import com.project.githubrepositoryapp.data.entity.GithubRepoEntity

@Database(entities = [GithubRepoEntity::class], version = 1)
abstract class SimpleGithubDatabase: RoomDatabase() {

    abstract fun repositoryDao(): RepositoryDao

}