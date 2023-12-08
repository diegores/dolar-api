package br.com.bb.desafio.host.data.response;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class QuoteResponse {
    @SerializedName("@odata.context")
    public String dataContext;
    public List<DolarQuoteResponse> value;
}
