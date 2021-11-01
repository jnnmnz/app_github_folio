package com.gitportfolio.data.repositories

import com.gitportfolio.data.model.Repo
import kotlinx.coroutines.flow.Flow

interface RepoRepositories {
    fun listRepositories(user:String) : Flow<List<Repo>>
}