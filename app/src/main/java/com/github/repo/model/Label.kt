package com.github.repo.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Label {
    @SerializedName("id")
    @Expose
    var id: String? = null

    @SerializedName("node_id")
    @Expose
    var nodeId: String? = null

    @SerializedName("url")
    @Expose
    var url: String? = null

    @SerializedName("name")
    @Expose
    var name: String? = null

    @SerializedName("color")
    @Expose
    var color: String? = null

    @SerializedName("default")
    @Expose
    var default: Boolean? = null

    @SerializedName("description")
    @Expose
    var description: Any? = null
}