package petShop;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public class MainPet {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		ArrayList<Empresa> empresas = new ArrayList<>();
		ArrayList<Animal> animais = new ArrayList<>();
		LocalDate agora = LocalDate.now();
		int nId = 1;

		while (true) {

			System.out.println("MENU");
			System.out.println("1 - cadastra empresa");
			System.out.println("2 - acessar empresa");
			System.out.println("3 - deletar empresa");
			System.out.println("4 - alterar dados da empresa");
			System.out.println("5 - listar empresa por ano");
			System.out.println("6 - buscar empresa");
			System.out.println("7 - listar empresa com mais animal");
			System.out.println("8 - listar empresa por ordem de cadastro");
			System.out.println("9 - listar empresa com edicao");
			System.out.println("10 - sair do sistema");

			System.out.println("qual opção voce gostaria? ");
			String pergunta = scanner.nextLine();

			switch (pergunta) {

			case "1":
				Empresa empr = new Empresa();

				System.out.println("Digite o nome");
				String nome = scanner.nextLine();
				empr.setNome(nome);

				System.out.println("Digite o nome fantasia");
				String nomeFantasia = scanner.nextLine();
				empr.setNomeFatasia(nomeFantasia);

				System.out.println("Digite o cnpj");
				Integer cnpj = Integer.valueOf(scanner.nextLine());
				empr.setCnpj(cnpj);

				empr.setDataCadastro(agora);

				empr.setAtivo(Status.ATIVIO);

				System.out.println("id: " + nId);
				empr.setId(nId++);

				empresas.add(empr);
				break;

			case "2":
				boolean continuar = true;
				if (empresas.isEmpty()) {
					System.out.println("voce nao tem empresas cadastrdas");
					continuar = false;
					break;
				}

				System.out.println("digite o id da empresa que voce quer");
				for (Empresa empresa : empresas) {
					System.out.println(
							"id da empresa: " + empresa.getId() + " - " + "nome da empresa: " + empresa.getNome());
				}
				// pegar id da empresa
				Integer idEmpresa = Integer.valueOf(scanner.nextLine());

				Empresa empresaSelecionada = null;
				for (Empresa empresa : empresas) {
					if (idEmpresa.equals(empresa.getId())) {
						empresaSelecionada = empresa;
					}
				}

				while (continuar) {

					System.out.println("1 - cadastra animal");
					System.out.println("2 - deletar animal");
					System.out.println("3 - listar animal ativos");
					System.out.println("4 - listar animal inativo");
					System.out.println("5 - listar animal por id");
					System.out.println("6 - editar animal");
					System.out.println("7 - listar animal por tipo");
					System.out.println("8 - voltar ao menu");

					System.out.println("qual opção voce gostaria? ");
					String menu = scanner.nextLine();

					switch (menu) {

					case "1":
						Animal ani = new Animal();

						String[] id3 = new String[9999];
						Random rr = new Random();
						int id4 = rr.nextInt(id3.length);
						ani.setId(id4);

						System.out.println("qual tipo do animal? 1 para cao e 2 para gato");
						String tipo = scanner.nextLine();
						if (tipo.equals("1")) {
							ani.setTipo(tipo.equals("1") ? Tipo.CAO : Tipo.GATO);
						}

						System.out.println("Digite o nome");
						String nomeAnimal = scanner.nextLine();
						ani.setNome(nomeAnimal);

						System.out.println("Digite a idade");
						Integer idade = Integer.valueOf(scanner.nextLine());
						ani.setIdade(idade);

						ani.setAtivo(Status.ATIVIO);

						System.out.println(id4);
						empresaSelecionada.getAnimais().add(ani);
						break;

					case "2":

						System.out.println("digite o id que quer deletar ");
						Integer deletar = Integer.valueOf(scanner.nextLine());

						for (Animal animal : empresaSelecionada.getAnimais()) {
							if (animal.getId().equals(deletar)) {
								animal.setAtivo(Status.INATIVO);
								animal.setDataDeletado(agora);
								break;
							}
						}
						break;

					case "3":

						Collections.sort(animais, (a, b) -> a.getNome().compareToIgnoreCase(b.getNome()));
						for (Animal animal : empresaSelecionada.getAnimais()) {
							if (animal.getAtivo() == Status.ATIVIO) {
								System.out.println("*nome " + animal.getNome() + " " + "*id: " + animal.getId() + " "
										+ "*idade: " + animal.getIdade() + " " + "*tipo: " + animal.getTipo());
							}
						}
						break;

					case "4":
						Collections.sort(animais, (a, b) -> a.getNome().compareToIgnoreCase(b.getNome()));
						for (Animal animal : empresaSelecionada.getAnimais()) {
							if (animal.getAtivo() == Status.INATIVO) {
								System.out.println("*nome " + animal.getNome() + " " + "*id: " + animal.getId() + " "
										+ "*idade: " + animal.getIdade() + " " + "*tipo: " + animal.getTipo());
							}
						}
						break;
					case "5":
						System.out.println("digite o id que quer listar ");
						Integer listar = Integer.valueOf(scanner.nextLine());

						for (Animal animal : empresaSelecionada.getAnimais()) {
							if (animal.getId().equals(listar)) {
								System.out.println("*nome " + animal.getNome() + " " + "*id: " + animal.getId() + " "
										+ "*idade: " + animal.getIdade() + " " + "*tipo: " + animal.getTipo());
								break;
							}
						}
						break;

					case "6":
						System.out.println("1 - editar nome ");
						System.out.println("2 - editar idade ");
						System.out.println("3 - editar tipo ");
						System.out.println("o que voce quer editar?  ");
						String opcoes = scanner.nextLine();

						System.out.println("qual o id de quem voce quer mudar?");
						Integer mudaId = Integer.valueOf(scanner.nextLine());

						switch (opcoes) {
						case "1":
							System.out.println("digite o novo nome: ");
							String novoNome = scanner.nextLine();

							for (Animal animal : empresaSelecionada.getAnimais()) {
								if (animal.getId().equals(mudaId)) {
									animal.setNome(novoNome);
									break;
								}
							}
							break;
						case "2":
							System.out.println("digite a nova idade: ");
							Integer novaIdade = Integer.valueOf(scanner.nextLine());

							for (Animal animal : empresaSelecionada.getAnimais()) {
								if (animal.getId().equals(mudaId)) {
									animal.setIdade(novaIdade);
									break;
								}
							}
							break;
						case "3":
							System.out.println("digite o novo tipo: 1 - para cao,  2 - para gato");
							String novoTipo = scanner.nextLine();

							for (Animal animal : empresaSelecionada.getAnimais()) {
								if (animal.getId().equals(mudaId)) {
									animal.setTipo(novoTipo.equals("1") ? Tipo.CAO : Tipo.GATO);
									break;
								}
							}
							break;
						}
						break;

					case "7":
						System.out.println("1 - lista de caes");
						System.out.println("2 - lista de gatos");
						String listaTipo = scanner.nextLine();

						if (listaTipo.equals("1")) {
							for (Animal animal : empresaSelecionada.getAnimais()) {
								if (animal.getTipo() == Tipo.CAO) {
									System.out.println(animal.getNome());
								}
							}
						} else if (listaTipo.equals("2")) {
							for (Animal animal : empresaSelecionada.getAnimais()) {
								if (animal.getTipo() == Tipo.GATO) {
									System.out.println(animal.getNome());
								}
							}
						}
						break;
					case "8":
						continuar = false;
						break;
					}
				}
				break;

			case "3":
				System.out.println("digite o id da empresa");
				Integer deletarEmpresa = Integer.valueOf(scanner.nextLine());

				System.out.println("voce tem certeza?");
				System.out.println("1 - sim");
				System.out.println("2 - nao");
				String resposta = scanner.nextLine();

				if (resposta.equals("1")) {
					for (Empresa empresa : empresas) {
						if (empresa.getId() == deletarEmpresa) {
							empresa.setAtivo(Status.INATIVO);
							empresa.setDataDeletado(agora);
						}
					}
				} else {
					break;
				}
				break;

			case "4":
				System.out.println("digite o id");
				Integer editaEmpresa = Integer.valueOf(scanner.nextLine());

				System.out.println("1 - eidtar o nome");
				System.out.println("2 - eidtar o nome fantasia");
				System.out.println("3 - eidtar o cnpj");
				System.out.println("escolha a sua opcao");
				String edicao = scanner.nextLine();

				switch (edicao) {
				case "1":

					System.out.println("digite o novo nome: ");
					String nomeEmpresa = scanner.nextLine();

					for (Empresa empresa : empresas) {
						if (empresa.getId() == editaEmpresa) {
							empresa.setNome(nomeEmpresa);
							empresa.setDataEdicao(agora);
							break;
						}
					}
					break;

				case "2":
					System.out.println("digite o novo nome fantasia: ");
					String nomeFantasiaEmpresa = scanner.nextLine();

					for (Empresa empresa : empresas) {
						if (empresa.getId() == editaEmpresa) {
							empresa.setNomeFatasia(nomeFantasiaEmpresa);
							empresa.setDataEdicao(agora);
							break;
						}
					}
					break;

				case "3":
					System.out.println("digite o novo cnpj: ");
					Integer novoCnpj = Integer.valueOf(scanner.nextLine());

					for (Empresa empresa : empresas) {
						if (empresa.getId() == editaEmpresa) {
							empresa.setCnpj(novoCnpj);
							empresa.setDataEdicao(agora);
							break;
						}
					}
					break;
				}
				break;

			case "5":
				System.out.println("de que ano voce quer as empresas?");
				Integer ano = Integer.valueOf(scanner.nextLine());

				for (Empresa empresa : empresas) {
					if (empresa.getDataCadastro().getYear() == ano) {
						System.out.println(empresa.getNome());
					}
				}
				break;

			case "6":
				System.out.println("digite a palavra a ser procurada");
				String palavra = scanner.nextLine();

				for (Empresa empresa : empresas) {
					if (empresa.getNomeFantasia().contains(palavra)) {
						System.out.println(empresa.getNomeFantasia());
					}
				}
				break;

			case "7":
				System.out.println("qual o numero de animais?");
				Integer quantidade = Integer.valueOf(scanner.nextLine());

				for (Empresa empresa : empresas) {
					if (empresa.getAnimais().size() >= quantidade) {
						System.out.println(empresa.getNome());
					}
				}
				break;

			case "8":
				Collections.sort(empresas, (a, b) -> a.getDataCadastro().compareTo(b.getDataCadastro()));
				for (Empresa empresa : empresas) {
					System.out.println(empresa.getDataCadastro() + " - " + empresa.getNome());
				}
				break;

			case "9":
				for (Empresa empresa : empresas) {
					if (empresa.getDataEdicao() != null) {
						System.out.println(empresa.getNome());
					}
				}
				break;

			case "10":
				System.exit(0);
				break;

			}
		}
	}
}
