<template>
  <div id="app">
    <section class="hero is-light is-fullheight">
      <div class="hero-body">
        <div class="container has-text-centered">
          <div class="column is-4 is-offset-4">
            <div class="box">
              <div class="field">
                <div class="control">
                  <input class="input is-large" type="email" placeholder="Eメール" v-model="email" autofocus="" v-validate="'required|email'" name="email">
                </div>
              </div>
              <div class="field">
                <div class="control">
                  <input class="input is-large" type="password" placeholder="パスワード" v-model="password" v-validate="'required|min:1|max:20'" maxlength="20" name="password">
                </div>
              </div>
              <br />
              <button v-on:click="login">ログイン</button>
            </div>
          </div>
        </div>
      </div>
    </section>
  </div>
</template>

<script>
import auth from '@/api/auth.js'
export default {
  data () {
    return {
      email: '',
      password: ''
    }
  },
  methods: {
    login () {
      auth.login(this.email, this.password)
        .then(() => this.$router.push('/book/list'))
    }
  }
}
</script>

<style scoped>
  @import "../assets/css/base.css";
</style>
