package tecsup.edu.poketinder

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import tecsup.edu.poketinder.databinding.ActivityLoginBinding

class LoginActivity : BaseActivity<ActivityLoginBinding>(ActivityLoginBinding::inflate){
    private lateinit var sharedPreferenceUtil: SharedPreferenceUtil
    override fun onCreate(saveInstanceState: Bundle?) {
        super.onCreate(saveInstanceState)
        sharedPreferenceUtil = SharedPreferenceUtil().also {
            it.setSharedPreference(this)
        }
        binding.btnLogin.setOnClickListener {
            startLogin()
        }
        binding.btnRegister.setOnClickListener {
            startActivity(Intent(this,RegisterActivity::class.java))
        }
    }
    private fun startLogin(){
        val email = binding.edtEmail.text.toString()
        val password = binding.edtPassword.text.toString()

        val user: User? = sharedPreferenceUtil.getUser()

        if(email == user?.email && password == user.password){
            startActivity(Intent(this,MainActivity::class.java))
        }else {
            Toast.makeText(this,"Error usuario",Toast.LENGTH_SHORT).show()
        }
    }
}