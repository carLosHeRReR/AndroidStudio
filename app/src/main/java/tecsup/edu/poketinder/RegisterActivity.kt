package tecsup.edu.poketinder

import android.content.Intent
import android.os.Bundle
import tecsup.edu.poketinder.databinding.ActivityRegisterBinding

class RegisterActivity : BaseActivity<ActivityRegisterBinding>(ActivityRegisterBinding::inflate){
    private lateinit var sharedPreferenceUtil: SharedPreferenceUtil
    override fun onCreate(saveInstanceState: Bundle?) {
        super.onCreate(saveInstanceState)

        sharedPreferenceUtil = SharedPreferenceUtil().also {
            it.setSharedPreference(this)
        }
        binding.btnRegister.setOnClickListener {
            val userId = "1"
            val userName = binding.edtUserName.text.toString()
            val email = binding.edtEmail.text.toString()
            val password = binding.edtPassword.toString()

            val user=User(
                userId,
                userName,
                email,
                password
            )
            sharedPreferenceUtil.saveUser(user)

            startActivity(Intent(this,LoginActivity::class.java))
        }
        binding.btnGoLogin.setOnClickListener {

        }
    }
}