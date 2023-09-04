package com.launchPad.web.domain.contract;

import lombok.Data;
import org.web3j.abi.datatypes.Bool;
import org.web3j.abi.datatypes.StaticStruct;
import org.web3j.abi.datatypes.generated.Uint256;

import java.math.BigInteger;

/**
 * @Author leedan
 * @Description :
 * @Date 2023/8/28  11:27
 * @Version 1.0
 */
@Data
public class ProjectStatusInfo extends StaticStruct {

    private  boolean WHITELIST_ONLY; // if set to true only whitelisted members may participate
    private  boolean LP_GENERATION_COMPLETE; // final flag required to end a presale and enable withdrawls
    private  boolean FORCE_FAILED; // set this flag to force fail the presale
    private BigInteger TOTAL_BASE_COLLECTED; // total base currency raised (usually ETH)
    private BigInteger  TOTAL_TOKENS_SOLD; // total presale tokens sold
    private BigInteger  TOTAL_TOKENS_WITHDRAWN; // total tokens withdrawn post successful presale
    private BigInteger  TOTAL_BASE_WITHDRAWN; // total base tokens withdrawn on presale failure
    private BigInteger  ROUND1_LENGTH; // in blocks
    private BigInteger  NUM_BUYERS;

    public ProjectStatusInfo(
            Bool WHITELIST_ONLY,
            Bool LP_GENERATION_COMPLETE,
            Bool FORCE_FAILED,
            Uint256 TOTAL_BASE_COLLECTED,
            Uint256 TOTAL_TOKENS_SOLD,
            Uint256 TOTAL_TOKENS_WITHDRAWN,
            Uint256 TOTAL_BASE_WITHDRAWN,
            Uint256 ROUND1_LENGTH,
            Uint256 NUM_BUYERS
    ) {
        super(WHITELIST_ONLY, LP_GENERATION_COMPLETE, FORCE_FAILED, TOTAL_BASE_COLLECTED, TOTAL_TOKENS_SOLD, TOTAL_TOKENS_WITHDRAWN, TOTAL_BASE_WITHDRAWN, ROUND1_LENGTH, NUM_BUYERS);
    }

    public void parse() {
        int i = 0;
        this.WHITELIST_ONLY = this.value.get(i++).getValue().toString().isEmpty();
        this.LP_GENERATION_COMPLETE = (boolean) this.value.get(i++).getValue();
        this.FORCE_FAILED = (boolean) this.value.get(i++).getValue();
        this.TOTAL_BASE_COLLECTED = (BigInteger) this.value.get(i++).getValue();
        this.TOTAL_TOKENS_SOLD = (BigInteger) this.value.get(i++).getValue();
        this.TOTAL_TOKENS_WITHDRAWN = (BigInteger) this.value.get(i++).getValue();
        this.TOTAL_BASE_WITHDRAWN = (BigInteger) this.value.get(i++).getValue();
        this.ROUND1_LENGTH = (BigInteger) this.value.get(i++).getValue();
        this.NUM_BUYERS = (BigInteger) this.value.get(i++).getValue();

    }
}
