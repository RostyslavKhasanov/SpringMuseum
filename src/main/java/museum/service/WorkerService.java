package museum.service;

import museum.dto.worker.*;
import museum.entity.Worker;

import java.util.List;

/**
 * Service interface for Worker entity.
 *
 * @author Rostyslav Khasanov
 * @version 1.0
 */
public interface WorkerService {

  /**
   * Save worker.
   *
   * @param workerSaveDto request worker dto.
   */
  void save(WorkerSaveDto workerSaveDto);

  /**
   * Get all workers.
   *
   * @return List of workerFirstSecondNameDtoResponse;
   */
  List<WorkerNamesDto> findAll();

  /**
   * Get worker by id.
   *
   * @param id worker id.
   * @return worker;
   */
  WorkerDto findById(Long id);

  /**
   * Get worker id by name.
   *
   * @param name worker name.
   * @return id of worker;
   */
  Long findWorkerIdByName(String name);

  /**
   * Get all free guides.
   *
   * @return List of WorkerDtoResponse;
   */
  List<WorkerNamesDto> findAllFreeGuide();

  /**
   * Get all guides.
   *
   * @return List of WorkerDtoResponse;
   */
  List<WorkerNamesDto> findAllGuide();

  /**
   * Get guides statistic.
   *
   * @return List of WorkerStatDtoResponse;
   */
  List<WorkerStatDto> findGuidesStat();

  /**
   * Delete worker by id.
   *
   * @param id worker id.
   */
  void deleteById(Long id);

  /**
   * Get worker by id..
   *
   * @return Worker;
   */
  Worker getOneById(Long id);

  /**
   * Update worker info.
   *
   * @param workerEditDto request worker dto.
   */
  void update(WorkerEditDto workerEditDto);

  List<WorkerNamesDto> filterByName(String pattern);
}
