# Github User App

## Architecture

- UI layer
- Domain layer
- Data layer

### UI Layer
- Fragment Navigation Graph
- DiffUtil Item Callback
- RecyclerView List Adapter
- RecyclerView View Holder
- Live Data and View Model
- Multiple Item View Type
- XML Data Binding Adapter
- Web Custom Chrome Tabs

### Domain Layer
- Dependency Injection Hilt
- Constant and Extension
- Kotlin Coroutines Flow
- GetUserListUseCase
- GetUserDetailUseCase

### Data Layer
- Parcelize and Parcelable
- UserRepository
- RepoRepository
- UserRemoteDataSource
- RepoRemoteDataSource
- Retrofit and OkHttp
- Glide Image Loading 

## GitHub REST API

### [Search user](https://docs.github.com/en/rest/search/search?apiVersion=2022-11-28#search-users)

- @GET("search/users")

### [Get a user](https://docs.github.com/en/rest/users/users?apiVersion=2022-11-28#get-a-user)

- @GET("users/{username}")

### [List repositories for a user](https://docs.github.com/en/rest/repos/repos?apiVersion=2022-11-28#list-repositories-for-a-user)

- @GET("users/{username}/repos")

Note：Keep personal access token in gradle.properties
