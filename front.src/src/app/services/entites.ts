export interface IZoos {
    id: number,
    name: string,
    place: string
}

export interface IFullUser{
    id: number,
    login: string,
    password: string,
    name?: string,
    email?: string,
    info?: string,
    role: string
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

export interface IEvent {
    name: string,
    type: string,
    ticketCost: number,
    date: Date,
    worker: string,
    zoo: string
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

export interface News {
    id: number;
    header: string;
    date: Date;
    content: string;
}


export class Resp {
  role: string;
}

export class RentialModel {
    name: string;
    email: string;
    zoo: string;
    animal: string;
    purpose: string;
    dateTake: Date;
    dateReturn: Date;
}
