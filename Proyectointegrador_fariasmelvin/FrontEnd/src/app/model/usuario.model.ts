export class usuario{
    idUsuario?: number;
    nomUsuario: String;
    apellUsuario: String;
    titUsuario: String; 
    descUsuario: String;
    fotPerfUsuario: String;

    constructor(nomUsuario: String,apellUsuario: String,titUsuario: String,descUsuario: String,fotPerfUsuario:String){
        this.nomUsuario = nomUsuario;
        this.apellUsuario = apellUsuario;
        this.titUsuario = titUsuario;
        this.descUsuario = descUsuario;
        this.fotPerfUsuario = fotPerfUsuario; 
    }
    


}