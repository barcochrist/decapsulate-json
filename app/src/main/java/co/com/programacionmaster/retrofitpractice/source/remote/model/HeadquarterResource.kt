package co.com.programacionmaster.retrofitpractice.source.remote.model

data class HeadquarterResource(
    val id: String,
    val companyId: String,
    val title: String,
    val longitude: Long,
    val latitude: Long,
    val businessTypeId: String
)