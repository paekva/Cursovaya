export interface IZoos {
    id: number,
    name: string,
    place: string
}

export interface IFullUser{
    login: string,
    password: string,
    name?: string,
    email?: string,
    info?: string
}

export interface IZoo {
    id: number,
    date: Date,
    manager: string,
    animals: number,
    place: string,
    name: string,
    func: string,
    employees: number
}

export interface IAnimal {
    id: number,
    name: string,
    age: number,
    type: string
}

export interface IType {
    id: number,
    name: string
}

export interface IEmployee {
    id: number,
    name: string,
    profession: string
}

export interface ITickets {
    id: number,
    zoo: string,
    date: Date
}

export class News {
    id: number;
    disc: string;
    fullDisc: string;
    src: string;
  }
  