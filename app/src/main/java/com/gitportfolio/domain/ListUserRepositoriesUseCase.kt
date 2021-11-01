package com.gitportfolio.domain

import br.com.dio.app.repositories.core.UseCase
import com.gitportfolio.data.model.Repo
import com.gitportfolio.data.repositories.RepoRepositories
import kotlinx.coroutines.flow.Flow

class ListUserRepositoriesUseCase(private val repository: RepoRepositories) : UseCase<String, List<Repo>>() {

    override suspend fun execute(param: String): Flow<List<Repo>> {
        return repository.listRepositories(param)
    }

}