package com.android.maplemate

import android.content.ContentValues.TAG
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.android.maplemate.databinding.ActivityLogintBinding
import com.navercorp.nid.NaverIdLoginSDK
import com.navercorp.nid.oauth.NidOAuthLogin
import com.navercorp.nid.oauth.OAuthLoginCallback

class LogintActivity : AppCompatActivity() {
    private val binding by lazy { ActivityLogintBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val view = binding.root
        setContentView(view)

        NaverIdLoginSDK.initialize(this, "rHXQWOt6SkX4gMgrzUAC", "umoFtpt5wS", "Maplemate") //초기화 시켜줌

        binding.btnLogin.setOnClickListener {
            NaverIdLoginSDK.authenticate(this, launcher)
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)

        }
        binding.btnDelete.setOnClickListener {
            NidOAuthLogin().callDeleteTokenApi(object : OAuthLoginCallback {
                override fun onSuccess() {
                    //서버에서 토큰 삭제에 성공한 상태입니다.
                    Log.d("LoginActivity","Success DeleteToken")
                }
                override fun onFailure(httpStatus: Int, message: String) {
                    // 서버에서 토큰 삭제에 실패했어도 클라이언트에 있는 토큰은 삭제되어 로그아웃된 상태입니다.
                    // 클라이언트에 토큰 정보가 없기 때문에 추가로 처리할 수 있는 작업은 없습니다.
                    Log.d(TAG, "errorCode: ${NaverIdLoginSDK.getLastErrorCode().code}")
                    Log.d(TAG, "errorDesc: ${NaverIdLoginSDK.getLastErrorDescription()}")
                }
                override fun onError(errorCode: Int, message: String) {
                    // 서버에서 토큰 삭제에 실패했어도 클라이언트에 있는 토큰은 삭제되어 로그아웃된 상태입니다.
                    // 클라이언트에 토큰 정보가 없기 때문에 추가로 처리할 수 있는 작업은 없습니다.
                    Log.d("LoginActivity","deleteToken()-> onError:${errorCode},message:${message}")
                    onFailure(errorCode, message)
                }
            })
        }
    }

    private val launcher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result: ActivityResult ->
            when (result.resultCode) {
                RESULT_OK -> {
                    Log.d("LoginActivity", "getAccessToken:${NaverIdLoginSDK.getAccessToken()}")
                    Log.d("LoginActivity", "getRefreshToken:${NaverIdLoginSDK.getRefreshToken()}")
                    Log.d("LoginActivity", "getTokenType:${NaverIdLoginSDK.getTokenType()}")
                }
                RESULT_CANCELED -> {
                    val errorCode = NaverIdLoginSDK.getLastErrorCode().code
                    val errorDescription = NaverIdLoginSDK.getLastErrorDescription()
                    Toast.makeText(
                        this,
                        "errorCode:$errorCode, errorDesc:$errorDescription",
                        Toast.LENGTH_SHORT
                    ).show()
                    Log.d("LoginActivity","errorCode:$errorCode/errorDesc:$errorDescription")
                    Log.d("LoginActivity","Error명:${NaverIdLoginSDK.getLastErrorDescription()}")
                }
            }
        }
}
