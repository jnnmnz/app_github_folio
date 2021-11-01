package com.gitportfolio.data.repositories

import com.gitportfolio.core.RemoteException
import com.gitportfolio.data.services.GitHubService
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException

class RepoRepositoriesImp(private val service: GitHubService) : RepoRepositories {

    override fun listRepositories(user: String) = flow {
        try {
            val repoList = service.listRepositories(user)
            emit(repoList)
        } catch (ex: HttpException) {
            throw RemoteException(ex.message ?: "NÃO FOI POSSÍVEL REALIZAR ESSA OPERAÇÃO")
        }

    }

}