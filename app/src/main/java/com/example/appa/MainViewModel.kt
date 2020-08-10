package com.example.appa

class MainViewModel() {
    // create repository instance
    public var repository: Repository = Repository()
    suspend fun sendFcm(message: String){
        repository.sendMessage();
    }
    suspend fun sendDirect(message: String){
        repository.sendMessageDirect(message)
    }
}