export class UserLogin{
    constructor(
        public login: string,
        public password: string,
        public name?: string,
        public email?: string,
        public info?: string
      ) { }
}